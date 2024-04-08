package be.intecbrussel.repository;

import be.intecbrussel.model.Country;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Optional;

public class CountryRepository {

    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;


    private CountryRepository countryRepository;
    public CountryRepository() {
        countryRepository = new CountryRepository();
    }
    public CountryRepository(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }
    public Country createCountry(Country country) {
        entityManager.getTransaction().begin();
        entityManager.persist(country);
        entityManager.getTransaction().commit();
        entityManager.close();
        return countryRepository.createCountry(country);
    }
    public Country updateCountry(Country country) {
        entityManager.getTransaction().begin();
        entityManager.merge(country);
        entityManager.getTransaction().commit();
        entityManager.close();
        return countryRepository.updateCountry(country);
    }
    public void deleteCountry(Country country) {
        entityManager.getTransaction().begin();
        entityManager.remove(country);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public Optional<Country> readCountry(int id) {
        entityManager.getTransaction().begin();
        Country country = entityManager.find(Country.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return Optional.ofNullable(country);
    }
}
