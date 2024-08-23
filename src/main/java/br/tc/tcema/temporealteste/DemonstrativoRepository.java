package br.tc.tcema.temporealteste;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemonstrativoRepository extends JpaRepository<DemonstrativoSchema, Long> {
}
