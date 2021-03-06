package mundo.DAO;


import MyList.MyList;
import mundo.DTO.IDto;
import mundo.SocketCliente.SocketCliente;

public abstract class AbsDao<T extends IDto> implements IDao<T>
{
	public AbsDao() 
	{
	}
	
	@Override
	public boolean insertar(SocketCliente sc, T dto) 
	{
		return sc.ejecutaActualizacion(dto.insertar());
	}

	@Override
	public boolean actualizar(SocketCliente sc, T dto) 
	{
		return sc.ejecutaActualizacion(dto.actualizar());
	}

	@Override
	public T consultarPk(SocketCliente sc, T dto) 
	{
 		MyList<T> result=  (MyList<T>) sc.ejecutaConsulta(dto.consultarPk());
		T idto= null;
		if(result.darTamanio()==1)
		{
			idto=result.dar(0);
		}
		return idto;
	}

	@Override
	public boolean eliminar(SocketCliente sc, T dto)
	{
		return sc.ejecutaActualizacion(dto.eliminar());
	}
	@Override
	public MyList<IDto> consultarTodos(SocketCliente sc,T dto)
	{
		MyList<IDto> result= sc.ejecutaConsulta(dto.consultarTodos());
		return result;
	}
	
}
