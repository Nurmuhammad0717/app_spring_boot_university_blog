package uz.pdp.app_hanshin_university.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.app_hanshin_university.entity.Attachment;
import uz.pdp.app_hanshin_university.entity.Post;
import uz.pdp.app_hanshin_university.entity.User;
import uz.pdp.app_hanshin_university.exception.RestException;
import uz.pdp.app_hanshin_university.mapper.PostMapper;
import uz.pdp.app_hanshin_university.payload.ApiResult;
import uz.pdp.app_hanshin_university.payload.AttachmentDTO;
import uz.pdp.app_hanshin_university.payload.PostCrudDto;
import uz.pdp.app_hanshin_university.payload.PostDTO;
import uz.pdp.app_hanshin_university.repository.AttachmentRepository;
import uz.pdp.app_hanshin_university.repository.PostRepository;
import uz.pdp.app_hanshin_university.repository.UserRepository;
import uz.pdp.app_hanshin_university.utils.AppConstant;

import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;


@Service
@RequiredArgsConstructor
@Transactional
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final AttachmentRepository attachmentRepository;
    private final PostMapper postMapper;

    @Override
    public ApiResult<PostDTO> create(PostCrudDto crudDto) {

        User user = userRepository.findById(crudDto.getUserId())
                .orElseThrow(()-> RestException.notFound("User "));

        Attachment attachment = attachmentRepository.findById(crudDto.getAttachmentDTO().getId())
                .orElseThrow(()->new RestException("If you don't upload media file you can post just a note"));

        Post post = new Post(
            user,
            crudDto.getTitle(),
            crudDto.getComment(),
            attachment,
            crudDto.getIsPrivate()
        );

        Post save = postRepository.save(post);

        return ApiResult.success(postMapper.toDto(post));
    }

    @Override
    public ApiResult<List<PostDTO>> read() {

        List<Post> posts = postRepository.findAll();

        List<PostDTO> postDTOS = postMapper.toDto(posts);

        for (PostDTO postDTO : postDTOS) {
            AttachmentDTO attachmentDTO = postDTO.getAttachmentDTO();

            attachmentDTO.setDownloadUrl(AppConstant.BASE_PATH_V1+"/attachment/"+attachmentDTO.getId());

        }

        return ApiResult.success(postDTOS);
    }

    @Override
    public ApiResult<PostDTO> readOne(UUID id) {

        Post post = postRepository.findById(id)
                .orElseThrow(()->new RestException("This post is not available"));

        PostDTO postDTO = postMapper.toDto(post);

        AttachmentDTO attachmentDTO = postDTO.getAttachmentDTO();

        attachmentDTO.setDownloadUrl(AppConstant.BASE_PATH_V1+"/attachment/"+attachmentDTO.getId());

        postDTO.setAttachmentDTO(attachmentDTO);

        return ApiResult.success(postDTO);
    }

    @Override
    public ApiResult<PostDTO> update(UUID id, PostCrudDto crudDto) {

        Post post = postRepository.findById(id)
                .orElseThrow(()->new RestException("This post is not available"));

     postMapper.updateEntity(post, crudDto);

        Post save = postRepository.save(post);

        return ApiResult.success(postMapper.toDto(save));
    }

    @Override
    public ApiResult<String> delete(UUID id) {

        Post post = postRepository.findById(id)
                .orElseThrow(()->new RestException("This post is not available"));

        postRepository.delete(post);

        return ApiResult.success("Post is deleted");
    }



}
