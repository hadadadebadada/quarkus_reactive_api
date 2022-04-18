package org.acme;
import javax.persistence.*;
@Entity
@NamedQuery(name = "Particles.findAll", query = "SELECT p FROM ParticleEntity p ORDER BY p.name")
public class ParticleEntity {
    private Long id;
    private String name;
    private String company;
    private String description;
    private Double initial_price;
    private Double price_2002;
    private Double price_2007;
    private String symbol;


    public ParticleEntity() {

    }

    @Id
    @SequenceGenerator(name = "particleSeq", sequenceName = "particle_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "particleSeq")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getInitial_price() {
        return initial_price;
    }

    public void setInitial_price(Double initial_price) {
        this.initial_price = initial_price;
    }

    public Double getPrice_2002() {
        return price_2002;
    }

    public void setPrice_2002(Double price_2002) {
        this.price_2002 = price_2002;
    }

    public Double getPrice_2007() {
        return price_2007;
    }

    public void setPrice_2007(Double price_2007) {
        this.price_2007 = price_2007;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "ParticleEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", description='" + description + '\'' +
                ", initial_price=" + initial_price +
                ", price_2002=" + price_2002 +
                ", price_2007=" + price_2007 +
                ", symbol='" + symbol + '\'' +
                '}';
    }
}