package alvaro.lopera.demo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import alvaro.lopera.demo.Entidades.Nave;

@Repository
public interface NaveRepository extends JpaRepository<Nave, Long> {
    
}
