package alvaro.lopera.demo.Entidades;

import javax.management.InvalidAttributeValueException;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table ( name = "Nave")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Nave {
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO )
    private Long id; 

    @NonNull
    private int health;

    public Nave ( Long l, int h ) {

        this.id = l;
        this.health = h;

    }

    public Long getId ( ) {
        return id;
    }

    public int getHealth ( ) {
        return health;
    }

    public boolean isAlive ( Nave n ) {
        return n.getHealth() > 0;
    }

    public void setHealth ( int h ) {
        this.health = h;
    }

    public void shootAt (Nave n) throws InvalidAttributeValueException { 

        if ( this.health <= 0 && !(n.isAlive(n)) ) {
            throw new InvalidAttributeValueException("ERROR: Invalid argument");
        }

        n.setHealth(n.getHealth() - 1);
        
    }

}
