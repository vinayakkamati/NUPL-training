package com.neptune.taskmanagement.mapper;

import com.neptune.taskmanagement.dto.ProjectDto;
import com.neptune.taskmanagement.model.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ProjectMapper {

    @Mapping(target = "dateCreated", dateFormat = "dd.MM.yyyy")
    ProjectDto ProjectToDto(Project project);

    @Mapping(target = "dateCreated", dateFormat = "d/MM/yyyy")
    Project DtoToProject(ProjectDto projectDto);
}
