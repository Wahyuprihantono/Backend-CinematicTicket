package com.bioskop.repository;

import com.bioskop.model.Films;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface FilmsRepository extends JpaRepository<Films, Integer> {

    public Films findByFilmId(Integer filmId);
    public Films findByFilmName(String filmName);

    // Get Film tayang by isShow
    @Query(value = "select * from Films f where f.is_show=true", nativeQuery = true)
    List<Films> getFilmTayang();
}
