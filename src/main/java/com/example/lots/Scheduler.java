package com.example.lots;


 import java.text.DateFormat;
 import java.text.SimpleDateFormat;
 import java.util.ArrayList;
 import java.util.Date;
 import java.util.List;

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
    private UserRepository userRepository;

    /*Every day Removal of all lots ending on that day in 00:00 */
    @Scheduled(cron = "0 0 0 * * ?")
    public void deleteEndLots() {
        Date curTime = new Date();
        DateFormat dtfrm = DateFormat.getDateInstance();
        String endDate = dtfrm.format(curTime);

        List<Lot> lots = new ArrayList<>();
        lotRepository.findByEndDate(endDate)
                .forEach(lots::add);

        System.out.println(0);
        lots.stream()
                .peek((e)
                        -> {
                            if(e.hasBuyer()) {
                                User tempUser = userRepository.findOne(e.getSeller().getUsername());
                                tempUser.addMoney(e.getPrice());
                                userRepository.save(tempUser);
                                tempUser  = userRepository.findOne(e.getBuyer().getUsername());
                                tempUser.subtractMoney(e.getPrice());
                                userRepository.save(tempUser);
                            }
                        }
                )
                .forEach(lotRepository :: delete);

    }
}
