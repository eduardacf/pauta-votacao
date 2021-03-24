package br.com.eduardacf.assembleia.repository;

import br.com.eduardacf.assembleia.entity.SessaoEntity;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SessaoRepository extends ReactiveMongoRepository<SessaoEntity, String> {
    @Query("{ 'idPauta': ?0}")
    Mono<SessaoEntity> findByIdPauta(String idPauta);

}
