package br.tc.tcema.temporealteste;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "PROGRESSO_DEMONSTRATIVO")
public class ProgressoDemonstrativoSchema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long demonstrativoId;
    private Integer progresso;
}
