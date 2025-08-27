package com.codewithvihanga.store.services;

import com.codewithvihanga.store.entities.Room;
import com.codewithvihanga.store.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }
    public Optional<Room> getRoomById(Long id) {
        return roomRepository.findById(id);
    }
    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }
    public Room updateRoom(Long id, Room updatedRoom) {
        return roomRepository.findById(id)
                .map(existing ->{
                    existing.setName(updatedRoom.getName());
                    existing.setDescription(updatedRoom.getDescription());
                    existing.setPricePerNight(updatedRoom.getPricePerNight());
                    existing.setCapacity(updatedRoom.getCapacity());
                    existing.setAvailable(updatedRoom.getAvailable());
                    return roomRepository.save(existing);
                })
                .orElse(null);
    }
    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }
}
