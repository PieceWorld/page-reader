package ru.example.pagereader;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Extension {
    public List <String> extension;

    public Extension() {
        this.extension = new ArrayList<>();
    }
}
