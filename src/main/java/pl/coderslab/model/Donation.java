package pl.coderslab.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "donations")
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private int quantity;

    @NotNull
    @ManyToMany
    private List<Category> categories = new ArrayList<>();

    @ManyToOne
    @NotNull
    private Institution institution;

    @NotBlank
    private String street;

    @NotBlank
    private String city;

    @Pattern(regexp = "[0-9]{2}-[0-9]{3}")
    private String zipCode;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;

    @NotNull
    private LocalTime pickUpTime;

    @NotBlank
    private String pickUpComment;
}
