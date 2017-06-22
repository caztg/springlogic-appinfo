package cn.springlogic.appinfo.jpa.repository;

import cn.springlogic.appinfo.jpa.entity.Protocol;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * Created by admin on 2017/6/15.
 */
@Configuration
@RepositoryRestResource(path = "appinfo:protocol")
public interface ProtocolRepository extends JpaRepository<Protocol, Integer> {

    @Query("select p from Protocol p where :position is null or p.position=:position")
    @RestResource(rel = "all", path = "all")
    Page<Protocol> findByPosition(@Param("position") String position, Pageable pageable);

}
