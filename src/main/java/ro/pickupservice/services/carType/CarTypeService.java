package ro.pickupservice.services.carType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.pickupservice.data.carType.CarTypeProvider;
import ro.pickupservice.data.carType.entity.CarType;

import java.util.List;

@Service
public class CarTypeService {

    @Autowired
    private CarTypeProvider carTypeProvider;

    public List<CarType> getCarTypes() {
        return carTypeProvider.getAllCarTypes();
    }
}
