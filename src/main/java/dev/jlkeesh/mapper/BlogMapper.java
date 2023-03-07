package dev.jlkeesh.mapper;

import dev.jlkeesh.domain.Blog;
import dev.jlkeesh.dto.blog.BlogCreateDTO;
import dev.jlkeesh.dto.blog.BlogDeleteDTO;
import dev.jlkeesh.dto.blog.BlogUpdateDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BlogMapper {
    Blog fromCreateDTO(BlogCreateDTO dto);

    List<Blog> fromCreateDTO(List<BlogCreateDTO> dtos);

    Blog fromUpdateDTO(BlogUpdateDTO dto);

    Blog fromDeleteDTO(BlogDeleteDTO dto);
}
