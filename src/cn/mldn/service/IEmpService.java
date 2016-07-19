package cn.mldn.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.mldn.vo.Emp;

public interface IEmpService {
	/**
	 * ʵ�ֹ�Ա���ݵ����Ӳ������ڱ�����֮����Ҫʹ��IEmpDAO�ӿ��е����·�����<br>
	 * <li>����Ҫ����IEmpDAO.findById()�����ж�Ҫ���ӵĹ�Ա����Ƿ���ڡ�</li>
	 * <li>�����Ա��Ų����ڣ���ʹ��IEmpDAO.doCreate()���������Ա��Ϣ</li>
	 * @param vo ������Ҫ�������ݵ�VO�����
	 * @return �������ӳɹ�����true�����򷵻�false
	 * @throws Exception IEmpDAO�ӿ��е��׳��쳣
	 */
	public boolean insert(Emp vo) throws Exception ;
	/**
	 * ʵ�����ݵ��޸Ĳ��������õ���IEmpDAO.doUpdate()�������˲�������ȫ���޸�
	 * @param vo ����Ҫ�޸ĵ�������Ϣ
	 * @return �޸ĳɹ�����true�����򷵻�false
	 * @throws Exception IEmpDAO�ӿ��е��׳��쳣
	 */
	public boolean update(Emp vo) throws Exception ;
	/**
	 * ʵ�����ݵ�����ɾ���������ڱ���������Ҫִ�����µ��ã�<br>
	 * <li>��Ҫ�ж�Ҫɾ�����ݴ���ļ��������Ƿ�Ϊ�գ��ж�null�Լ�size()��</li>
	 * <li>���ȷ����ɾ�������ݣ������IEmpDAO.doRemove()����ɾ��</li>
	 * @param ids ������Ҫɾ�����ݵ�����ID����
	 * @return ɾ���ɹ�����true�����򷵻�false
	 * @throws Exception IEmpDAO�ӿ��е��׳��쳣
	 */
	public boolean delete(Set<Integer> ids) throws Exception ;
	/**
	 * ���ݹ�Ա��Ų�ѯ��һ����Ա��������Ϣ�����õ���IEmpDAO.findById()������ѯ
	 * @param id Ҫ��ѯ�Ĺ�Ա�����Ϣ
	 * @return ������Բ�ѯ����Ա����VO����ʽ���أ������ѯ�����򷵻�null
	 * @throws Exception IEmpDAO�ӿ��е��׳��쳣
	 */
	public Emp get(int id) throws Exception ;
	/**
	 * ��ѯ��Ա��ȫ�����ݣ����õ���IEmpDAO.findAll()������ѯ
	 * @return ���еĲ�ѯ��¼��List���Ϸ���
	 * @throws Exception IEmpDAO�ӿ��е��׳��쳣
	 */
	public List<Emp> list() throws Exception ;
	
	public List<Emp> listDetails() throws Exception ;
	/**
	 * ʵ�����ݵ�ģ����ѯ������ͬʱ�᷵�ط��ϲ�ѯҪ������������ڱ��˲�����Ҫ�������µĹ��ܣ�<br>
	 * <li>����IEmpDAO.findAllSplit()��������ҳ��ѯҪ��ʾ�����ݣ�</li>
	 * <li>����IEmpDAO.getAllCount()������ͳ�����ݵĸ���</li>
	 * @param column ģ����ѯ���ֶ�
	 * @param keyWord ģ����ѯ�ؼ���
	 * @param currentPage ��ǰ����ҳ 
	 * @param lineSize ÿҳ����ʾ����
	 * @return ������Ҫ�����������ݣ�����ʹ��Map���Ϸ��أ����ֵ��������£�<br>
	 * <li>key = allEmps��value = IEmpDAO.findAllSplit()�����ص���List&lt;Emp&gt;</li>
	 * <li>key = empCount��value = IEmpDAO.getAllCount()�����ص���Integer</li>
	 * @throws Exception IEmpDAO�ӿ��е��׳��쳣
	 */
	public Map<String,Object> listSplit(String column,String keyWord,int currentPage,int lineSize) throws Exception ;
	public Emp getDetails(int id) throws Exception ;
	
}
