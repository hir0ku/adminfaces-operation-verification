package com.example.admin_faces_operation_verification;

import lombok.Getter;
import lombok.Setter;
import org.omnifaces.util.Messages;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Named
@ViewScoped
public class IndexView implements Serializable {

    @Getter
    private List<String> itemCandidates;

    @Getter
    private LazyDataModel<TableItemDto> tableItemDtoList;

    @Getter
    @Setter
    private String selectOne;

    public void init() {
        this.itemCandidates = List.of("aaa", "bbb", "ccc", "ddd");
        this.tableItemDtoList = new LazyDataModel<>() {
            @Override
            public List<TableItemDto> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {

                List<TableItemDto> collect = IntStream.rangeClosed(0, pageSize)
                        .mapToObj(m -> TableItemDto.createRandomItem())
                        .collect(Collectors.toList());
                setRowCount(collect.size());
                return collect;
            }
        };
    }

    public void submit() {
        Messages.addGlobalInfo("Select One {0}", selectOne);
    }
}
