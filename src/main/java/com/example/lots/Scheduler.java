package com.example.lots;


 import java.text.DateFormat;
 import java.text.ParseException;
 import java.text.SimpleDateFormat;
 import java.util.ArrayList;
 import java.util.Calendar;
 import java.util.Date;
 import java.util.List;

 import com.example.purchases.Purchase;
 import com.example.purchases.PurchaseRepository;
 import com.example.users.User;
 import com.example.users.UserRepository;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
 import org.springframework.scheduling.annotation.EnableScheduling;
 import org.springframework.scheduling.annotation.Scheduled;
 import org.springframework.stereotype.Service;


@Service
@EnableScheduling
public class Scheduler {

    @Autowired
    private LotRepository lotRepository;

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private UserRepository userRepository;


    /*Every day Removal of all lots ending on that day in 00:00 */
    /* Add EndPaymentDay as throw 2 days*/
    @Scheduled(cron = "0 0 0 * * ?")
    public void deleteEndLots() {
        Date curTime = new Date();
        DateFormat dtfrm = DateFormat.getDateInstance();
        String endDate = dtfrm.format(curTime);

        List<Lot> lots = new ArrayList<>();
        lotRepository.findByEndDate(endDate)
                .forEach(lots::add);
        lots.stream()
                .peek((e)
                        -> {
                        Purchase purchase = new Purchase(e);
                        Calendar cal = Calendar.getInstance();
                        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                        String nowDate = sdf.format(cal.getTime());
                            try {
                                Date d = sdf.parse(nowDate);
                                long msdate = d.getTime();
                                long twoday = 2*86400000L;

                                Date ms = new Date(msdate+twoday);
                                purchase.setPurchaseDate(sdf.format(ms));

                            } catch (ParseException e1) {
                                e1.printStackTrace();
                            }
                        purchaseRepository.save(purchase);

                        }
                )
                .forEach(lotRepository :: delete);

    }

    @Scheduled(cron = "0 0 0 * * ?")
    public void checkPurchases(){
        System.out.println(1);
        Date curTime = new Date();
        DateFormat dtfrm = DateFormat.getDateInstance();
        String endDate = dtfrm.format(curTime);
        System.out.println(2);
        List<Purchase> purchases = new ArrayList<>();
        System.out.println(3);
        purchaseRepository.findByPurchaseDate(endDate)
                .forEach(purchases::add);
        System.out.println(purchases.size()+"*");
        for(Purchase purchase: purchases){
            if(purchase.getStatus().equals("NOT PAID")){
                purchase.setStatus("CLOSED");
                purchase.getBuyer().addPenalty(0.2*purchase.getPrice());//Add penalty
                userRepository.save(purchase.getBuyer());
                purchaseRepository.save(purchase);
            }
        }

        System.out.println("0000");
    }
}
