package com.alamin_tanveer.supplychain.entities.third_party;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "nid_storage")
public class NIDStorage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nid;
}
