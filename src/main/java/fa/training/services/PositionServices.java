package fa.training.services;

import java.util.List;

import fa.training.entities.Position;

public interface PositionServices {
	public List<Position> getAll();
	public Position getByID(int id);
}
