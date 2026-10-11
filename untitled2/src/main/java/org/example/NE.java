package org.example;
@Entity
public class NE {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String IP;
    private String name;




}
