public class Directory {

	private String split(String s) {
		StringTokenizer t = new StringTokenizer(s.tri);
	}
	public String[] display(String[] files) {
		Arrays.sort(files);
		List<String> res = new LinkedList<>();
		String[] prev = null;
		for (int i = 0; i < files.length; i++) {
			String file = files[i];
			String[] f = split(file);
			int posAdja; // adjacent pos
			for (posAdja = 0; prev != null && posAdja < prev.length 
				&& posAdja < f.length && f[posAdja] == prev[posAdja]; posAdja++) {
			}
			for (int j = 0; j < res.size(); j++) {
				if (res.get(j).charAt)
			}
		}
	}
}