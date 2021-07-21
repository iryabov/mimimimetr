package mimimimetr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class CatCouple {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cat_couple_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "first_cat", referencedColumnName = "cat_id")
    private Cat firstCat;

    @ManyToOne
    @JoinColumn(name = "second_cat", referencedColumnName = "cat_id")
    private Cat secondCat;

    public Long getId() {
        return id;
    }

    public CatCouple(Cat firstCat, Cat secondCat) {
        this.firstCat = firstCat;
        this.secondCat = secondCat;
    }

    public CatCouple() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cat getFirstCat() {
        return firstCat;
    }

    public void setFirstCat(Cat firstCat) {
        this.firstCat = firstCat;
    }

    public Cat getSecondCat() {
        return secondCat;
    }

    public void setSecondCat(Cat secondCat) {
        this.secondCat = secondCat;
    }

    @Override
    public String toString() {
        return id + "";
    }

}
