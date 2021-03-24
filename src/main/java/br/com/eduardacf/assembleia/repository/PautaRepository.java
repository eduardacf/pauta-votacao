package br.com.eduardacf.assembleia.repository;

import br.com.eduardacf.assembleia.entity.PautaEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PautaRepository extends ReactiveMongoRepository<PautaEntity, String> {
}
