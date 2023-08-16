package br.com.sicoob.helpdesk.dto.response;

import br.com.sicoob.helpdesk.entities.CategoryOfManuals;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryOfManualResponse {

    private Long cdCategory;

    private String category;

    private List<ManualDocResponse> manual;


}
