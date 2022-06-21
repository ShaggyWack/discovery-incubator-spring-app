package com.example.movie_demo_java;

import com.example.movie_demo_java.generated_implementation.mappers.AppModelMapper;
import com.gen.movie_demo_java.comicstock.models.IssueDto;
import com.gen.movie_demo_java.comicstock.models.ResourceDto;
import com.gen.movie_demo_java.movies.models.Movie;
import com.gen.movie_demo_java.movies.models.MovieImages;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class MovieDemoJavaApplicationTests {

	@Test
	public void shouldAppModelMapperMapIssueDtoToMovie(){
		Movie mockMovieResult = createMockMovieObject();

		IssueDto issueDto = mock(IssueDto.class);

		when(issueDto.getTitle()).thenReturn("Civil War");
		when(issueDto.getId()).thenReturn(1);
		when(issueDto.getDescription()).thenReturn("The movie where they fight");

		List<ResourceDto> images = new ArrayList<>();
		ResourceDto mockResourceDto = new ResourceDto();
		mockResourceDto.setExtension("jpg");
		mockResourceDto.setPath("base/dir/image");
		images.add(mockResourceDto);

		when(issueDto.getImages()).thenReturn(images);


		assertEquals(mockMovieResult,AppModelMapper.fromIssueDTOToMovieModel(issueDto));
	}

	private Movie createMockMovieObject(){
		Movie mockMovieResult = new Movie();

		MovieImages mockMovieImages = createMockMovieImagesObject();

		mockMovieResult.setId(1L);
		mockMovieResult.setTitle("Civil War");
		mockMovieResult.setDescription("The movie where they fight");
		mockMovieResult.setImages(mockMovieImages);

		return mockMovieResult;
	}

	private MovieImages createMockMovieImagesObject(){
		MovieImages mockMovieImages = new MovieImages();
		mockMovieImages.setExtension("jpg");
		mockMovieImages.setPath("base/dir/image");

		return mockMovieImages;
	}
}
