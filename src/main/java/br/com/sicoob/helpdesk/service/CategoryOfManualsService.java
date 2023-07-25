package br.com.sicoob.helpdesk.service;

import br.com.sicoob.helpdesk.dto.request.CategoryOfManualRequest;
import br.com.sicoob.helpdesk.dto.response.CategoryOfManualResponse;
import br.com.sicoob.helpdesk.dto.response.ManualDocResponse;
import br.com.sicoob.helpdesk.dto.response.SendSMSResponse;
import br.com.sicoob.helpdesk.entities.CategoryOfManuals;
import br.com.sicoob.helpdesk.repository.CategoryOfManualsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryOfManualsService {

    @Autowired
    private CategoryOfManualsRepository repository;

    /*
    /metodo para listar todas as categorias e retornar os manuais
     */
    @Transactional
    public List<CategoryOfManualResponse> listAllCategory() {

        List<CategoryOfManuals> categories = repository.findAll();

        List<CategoryOfManualResponse> categoryOfManualResponses = new ArrayList<>();

        for(CategoryOfManuals category: categories) {
            List<ManualDocResponse> manuaisDTOs = category.getManuais().stream()
                    .map(manual -> new ManualDocResponse(manual.getId(), manual.getDocName(), manual.getDocType(),manual.getData(), manual.getCategory()))
                    .collect(Collectors.toList());

            categoryOfManualResponses.add(new CategoryOfManualResponse(category.getCdCategory(), category.getCategory(), manuaisDTOs));
        }

        return categoryOfManualResponses;
    }

    /*
    metodo para cadastrar uma nova categoria
     */
    public CategoryOfManualResponse createNewCategory(CategoryOfManualRequest category) {

        CategoryOfManuals newCategory = new CategoryOfManuals();

        newCategory.setCdCategory(category.getCdCategory());
        newCategory.setCategory(category.getCategory());
        newCategory.setManuais(new ArrayList<>());

        repository.save(newCategory);

        return new CategoryOfManualResponse(newCategory.getCdCategory(), newCategory.getCategory(), new ArrayList<>());
    }

    /*
    * metodo para excluir uma categoria
    * */
    public String deleteCategory() {
        return "";
    }

}
