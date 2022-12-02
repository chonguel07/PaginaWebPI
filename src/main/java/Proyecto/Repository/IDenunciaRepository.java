package Proyecto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Proyecto.Model.Denuncia;


@Repository
public interface IDenunciaRepository extends JpaRepository<Denuncia, Integer>{

}
