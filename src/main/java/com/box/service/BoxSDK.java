package com.box.service;

import com.box.sdk.BoxDeveloperEditionAPIConnection;

public interface BoxSDK {
	
	public static final String PUBLIC_ID = "yc2y4m23";
	public static final String PRIVATE_KEY_PASSWORD = "de6a6c059830424bda18ad379ea5474a";
	public static final String PRIVATE_KEY = "-----BEGIN ENCRYPTED PRIVATE KEY-----\nMIIFDjBABgkqhkiG9w0BBQ0wMzAbBgkqhkiG9w0BBQwwDgQIPYVMZsBG6ZECAggA\nMBQGCCqGSIb3DQMHBAgPGdLY28xsDwSCBMigLClMATaq5zLycgM6kNwCUbdG9E2W\nfiQtj0P+wtYEiKX21RL7j83xd39kiOy7JmtDkpLhJ/3mfNMNtGcR1I7VR7PrZH8j\nMjvXyXEnSKCpTKMdS1pO8fLOo03JqvDiA1U2PiskpBynkbmQdZU2smXcvyEYVc6P\n6Mowam2lFg8KKwUEh6Ga/YgCgJ9/w/yiDJ/UcOykpkFYo3aZUBAyb3eMXiqlJsXy\n9vNu4Ic8XnXwzhRkfvm84fawn3CvOQKHRdYsFkADNJeK2WQrsKO7m2YlIVAAADpq\n2Phquvesi8qB8K2Ho/dlyN2BeNQ3fjkWOeuFu/r+FfzVV0DXYKCCs/qwTC0lYX8B\nobfto+zjLehBH9DmQuFiahxNaFO1pQfa2/K3kgxIn38hyQyM5FDww3PZKHQE1+Qd\nFs7g/KCC70IZb/OSBx7u/NmadxS6TUn5iIUfcxBIUdiBRoqBskD0ZqFf9P318ACA\ne+QbBmHoamXpCye0q5cqpnfRgOY0cWkwK35nNBXjJeHpYEsrVJ4Ajqr2QEwBYN45\nf8Uj+Gv0a5fM6THENTQfOvx81+JVTo8vyzPzpayqJXRkKgQ8rTuEp4cL/CSKmeHd\nIDkIzUQ7M9jzHiESD5H8HUCHRHeP6BntxYoW63m2z4vMzdfjSZLq3LU+E+sNwq6x\nBjoqO0D7Himle2eIv92mWSV5vp0ipZiyLCubYYS1nqDpVNLVnVS6wCA0swE7E2n8\nV5N+yWJFHvIcOFboVAU+ZMIkF4VYDY9MVdJ37ej9pNgz2LOYpciTjtbmS9Fe75o2\nnRcFbQTNm4kRDidETL5J5igUSp1nolT4oSusQdS+H7VgdapYKMUDfXykA8F5rsyi\ndISdRFZedLP84e7YwUkpXiCYqCF7RcYRUlbYT8u4tYbPbEt4woZ22sGcsQfRXOD0\na4nHSrwxUU1G0voBItHIp9xbxSHkY/ZS/F2XVDbzQ1doPWj4/+IGm/4KetrIrRdq\ndVjuKntdxQBqm3r/01nUHsyG2so/yrX9r6c9WiA/LO3toSJlTV/Hc/tRW2QqWVcR\nBn1i9UUNo47SFTAOwXhNqv1dParu/cWwMNqOKVyoqh5rVxs1e1qOQLFGjAXKDrSO\nYxhVIqU9Sr+TcY7MCyECbptraIbhC9MbqHqnAKH1ZnY/x0G6FxpOku42ePR9nTn2\nYJ/A/bZDH/rQpRDm/QAKxIqavIIzsJLV+9r2ofZ1IVU4DiCpLP0EYQUKBel9WWys\n9nZ9Pn/sXvCl69WtST1rkawziR/aPjdVs09jo+BfWEBMA8PxlHhz8lZxn2oa9X17\nMmxHh52+CBlBkJd9nfis3aT5SvvNlcgcxyhN3VjJZHNPTizw6pxENHFsgs2hNAma\nQll0p8UgubETtrFy9nvw0cAqDdaOOIEXgyXlqoryzrXA5IKh10ksqJ0LrTc4fxfq\ncslv+XRsLRUJJDTUKOYJgcCXeiZ6sftfGUsRHrdFv+FBaJEeVV1Vl0owIgBv1xjE\n7mYCPHtMuZFE47LO1HFPCTYAFrIEwOwQ1Sz6rIUPuSWtg7xKmizr59uKhbtgUHoO\nljDJZjP3jaXlhW0gc37hX20W/yPRvdGvNuidLJoootHMtsPstnqiH5cY34/Lm8QT\nRqw=\n-----END ENCRYPTED PRIVATE KEY-----\n";
	public static final String CLIENT_ID = "quctsqlnvjtanl507z6axh22jyd9jzg1";
	public static final String CLIENT_SECRET = "37isljVOklKg3CY91Z737sEU1ORisS84";
	public static final String ENTEPRISE_ID = "59194496";
	public static final String CLIENT_DOCS_FOLDER_ID = "50549221099";
	public static final String CLIENTS_GROUP_ID = "1130473120";

	public String getServiceAccountAccessToken() throws Exception;
	public String getAppUserAccessToken(String userId) throws Exception;
	public BoxDeveloperEditionAPIConnection getServiceAccountConnection() throws Exception;

}
