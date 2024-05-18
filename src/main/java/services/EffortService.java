package services;

import data.dao.EffortRepository;
import data.objects.Effort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EffortService {
     @Autowired
     EffortRepository effortRepository;
     public Effort getEffortByDate(Date date){
         return effortRepository.findEffortByDate(date);   }

     public Effort getEffortById(Long id) {
        return effortRepository.findEffortById(id);
    }


     public Effort updateEffort(Effort effort) {
        effortRepository.save(effort);
        return effort;
    }

     public void deleteEffortById(Long id) {
        effortRepository.deleteById(id);
    }
}
