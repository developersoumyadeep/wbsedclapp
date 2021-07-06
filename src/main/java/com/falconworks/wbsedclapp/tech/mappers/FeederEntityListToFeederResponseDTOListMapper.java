package com.falconworks.wbsedclapp.tech.mappers;

import com.falconworks.wbsedclapp.tech.dto.FeederResponseDTO;
import com.falconworks.wbsedclapp.tech.entities.Feeder;

import java.util.List;
import java.util.stream.Collectors;

public class FeederEntityListToFeederResponseDTOListMapper {
     public static List<FeederResponseDTO> map(List<Feeder> feeders) {
         return feeders.stream().map(feeder -> FeederEntityToFeederResponseDTOMapper.map(feeder)).collect(Collectors.toList());
     }
}
