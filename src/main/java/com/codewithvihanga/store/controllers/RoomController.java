package com.codewithvihanga.store.controllers;

import com.codewithvihanga.store.dtos.RoomDto;
import com.codewithvihanga.store.entities.Room;
import com.codewithvihanga.store.mappers.RoomMapper;
import com.codewithvihanga.store.repository.RoomRepository;
import com.codewithvihanga.store.services.RoomService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/rooms")
public class RoomController {
    private final RoomService roomService;
    private final RoomMapper roomMapper;

    @GetMapping
    public List<RoomDto> getAllRooms(){
        return roomService.getAllRooms()
                .stream()
                .map(roomMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomDto> getRoomById(@PathVariable Long id){
        return roomService.getRoomById(id)
                .map(roomMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<RoomDto> createRoom(@Valid @RequestBody RoomDto roomDto) {
        Room room = roomMapper.toEntity(roomDto);
        Room saved = roomService.saveRoom(room);
        return ResponseEntity.ok(roomMapper.toDto(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoomDto> updateRoom(@PathVariable Long id ,@RequestBody RoomDto roomDto){
        Room updated = roomService.updateRoom(id, roomMapper.toEntity(roomDto));
        return (updated!=null) ? ResponseEntity.ok(roomMapper.toDto(updated)) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoom(@PathVariable Long id){
        roomService.deleteRoom(id);
        return ResponseEntity.noContent().build();
    }

}
