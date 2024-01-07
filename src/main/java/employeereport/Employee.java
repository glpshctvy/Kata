package employeereport;

import lombok.Getter;

@Getter
public record Employee(
    String name,
    int age
) {

}
