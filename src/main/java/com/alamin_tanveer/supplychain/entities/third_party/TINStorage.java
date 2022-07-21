package com.alamin_tanveer.supplychain.entities.third_party;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tin_storage")
public class TINStorage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String tinId;
}
