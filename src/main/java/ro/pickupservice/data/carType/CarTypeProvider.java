package ro.pickupservice.data.carType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.pickupservice.data.carType.entity.CarType;

import java.util.List;

@Service
public class CarTypeProvider {

    @Autowired
    private CarTypeRepository carTypeRepository;

    public CarType getCarTypeById(Long carTypeId) {
        return carTypeRepository.findOne(carTypeId);
    }

    public List<CarType> getAllCarTypes() {
        return carTypeRepository.findAll();
    }
}
