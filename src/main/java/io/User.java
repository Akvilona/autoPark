package io;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder
public class User implements Serializable {
    private int id;
    private String name;
    private int age;
}
