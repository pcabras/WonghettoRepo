package be.pcab.wonghetto.wonghettoserver.exchangeprotocol;

public interface Processor<T> {

	/**
	 * Processes objects of type T
	 * 
	 * @return
	 */
	T process(T objectToProcess) throws Exception;
}
