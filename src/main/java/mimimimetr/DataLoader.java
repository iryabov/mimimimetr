package mimimimetr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import mimimimetr.entity.Cat;
import mimimimetr.entity.CatCouple;
import mimimimetr.entity.VoteResult;
import mimimimetr.repository.CatCoupleRepo;
import mimimimetr.repository.CatRepo;
import mimimimetr.repository.VoteResultRepo;


@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private CatRepo catRepo;

    @Autowired
    private CatCoupleRepo catCoupleRepo;

    @Autowired
    private VoteResultRepo voteResultRepo;

    @Override
    public void run(String... args) throws Exception {

        catRepo.save(new Cat("Барон", "/image/cats/барон.jpg"));
        catRepo.save(new Cat("Барсик", "/image/cats/барсик.jpg"));
        catRepo.save(new Cat("Белик", "/image/cats/белик.jpg"));
        catRepo.save(new Cat("Вислоух", "/image/cats/вислоух.jpg"));
        catRepo.save(new Cat("Маркиз", "/image/cats/маркиз.jpg"));
        catRepo.save(new Cat("Рыжик", "/image/cats/рыжик.jpg"));

        List<Cat> cats = (List<Cat>) catRepo.findAll();

        for (int i = 0; i < cats.size(); i++) {
            for (int j = i + 1; j < cats.size(); j++) {
                catCoupleRepo.save(new CatCouple(cats.get(i), cats.get(j)));
            }
        }

        for (Cat cat : cats) {
            voteResultRepo.save(new VoteResult(cat, 0L));
        }
    }

}
