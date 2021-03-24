package br.com.eduardacf.assembleia.repository;

import br.com.eduardacf.assembleia.entity.VotoEntity;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface VotoRepository extends ReactiveMongoRepository<VotoEntity, String> {

    @Query("{ 'idPauta': ?0, 'cpfPessoa': ?1}")
    Mono<VotoEntity> findByIdPautaAndCpfPessoa(String idPauta, String cpfPessoa);

}
