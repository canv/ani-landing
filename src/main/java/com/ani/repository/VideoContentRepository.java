package com.ani.repository;

import com.ani.domain.VideoContent;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface VideoContentRepository extends CrudRepository<VideoContent, UUID> {
    VideoContent findFirstByNumber(long number);
}