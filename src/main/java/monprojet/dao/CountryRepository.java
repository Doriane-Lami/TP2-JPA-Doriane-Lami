package monprojet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import monprojet.entity.City;
import monprojet.entity.Country;

// This will be AUTO IMPLEMENTED by Spring 

public interface CountryRepository extends JpaRepository<Country, Integer> {

    @Query(value = "SELECT SUM(population) AS pop "
            + "FROM City "
            + "WHERE City.country_id = :idcherche ",
            nativeQuery = true)
    public int populationCountry(Integer idcherche);


    @Query(value = "SELECT Country.name AS nom, SUM(City.population) AS pop "
            + "FROM City INNER JOIN Country USING (id) "
            + "GROUP BY nom",
            nativeQuery = true)
    public List<DTO> populationParPays();


}
