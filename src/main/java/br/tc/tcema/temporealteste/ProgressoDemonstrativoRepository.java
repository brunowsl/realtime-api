package br.tc.tcema.temporealteste;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgressoDemonstrativoRepository extends JpaRepository<ProgressoDemonstrativoSchema, Long> {
    ProgressoDemonstrativoSchema findByDemonstrativoId(Long demonstrativoId);
}
