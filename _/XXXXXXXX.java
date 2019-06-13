package XXXXXXXX_PACKAGE.model;


import com.pactera.jep.entity.BasePO;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.sql.Time;
import java.sql.Timestamp;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "XXXXXXXX_DB")
public class XXXXXXXX extends BasePO {
	
	XXXXXXXX_CONTENT
	
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(getId())
                .toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof XXXXXXXX == false) {
            return false;
        }
        if(this == obj) {
            return true;
        }
        XXXXXXXX other = (XXXXXXXX)obj;
        return new EqualsBuilder()
                .append(getId(),other.getId())
                .isEquals();
    }
}
