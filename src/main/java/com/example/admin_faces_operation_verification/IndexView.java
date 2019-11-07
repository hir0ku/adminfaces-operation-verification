package com.example.admin_faces_operation_verification;

import lombok.Getter;
import lombok.Setter;
import org.omnifaces.util.Messages;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Named
@ViewScoped
public class IndexView implements Serializable {

    @Getter
    private List<String> itemCandidates;

    @Getter
    private List<TableItemDto> tableItemDtoList;

    @Getter
    @Setter
    private String selectOne;

    public void init() {
        this.itemCandidates = List.of("aaa", "bbb", "ccc", "ddd");
        this.tableItemDtoList = IntStream.rangeClosed(0, 500)
                .mapToObj(m -> TableItemDto.createRandomItem())
                .collect(Collectors.toList());
    }

    public void submit() {
        Messages.addGlobalInfo("Select One {0}", selectOne);
    }
}
