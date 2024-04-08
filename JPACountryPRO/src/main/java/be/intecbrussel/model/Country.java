package be.intecbrussel.model;

import javax.persistence.*;

@Entity
@Table(name = "country")
public class Country {
    @Id
    @Column(name = "country_name")
    private String name;

    @Column(name = "country_population")
    private int population;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
    private President president;

    protected Country() {
    }
    public Country(String name, int population) {
        this.name = name;
        this.population = population;
    }
    public Country(String name, int population, President president) {
        this(name, population);
        this.president = president;
    }


    public String getCountryName() {
        return name;
    }

    public void setCountryName(String countryName) {
        this.name = countryName;
    }

    public int getCountryPopulation() {
        return population;
    }

    public void setCountryPopulation(int countryPopulation) {
        this.population = countryPopulation;
    }

    public President getPresident() {
        return president;
    }

    public void setPresident(President president) {
        this.president = president;
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryName='" + name + '\'' +
                ", countryPopulation=" + population +
                ", president=" + president +
                '}';
    }
}
