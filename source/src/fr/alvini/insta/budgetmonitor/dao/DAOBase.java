package fr.alvini.insta.budgetmonitor.dao;

import java.text.SimpleDateFormat;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import fr.alvini.insta.budgetmonitor.bdd.Database;

public abstract class DAOBase {
	public final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	// Nous sommes � la premi�re version de la base
	// Si je d�cide de la mettre � jour, il faudra changer cet attribut
	protected final static int VERSION = 1;
	// Le nom du fichier qui repr�sente la base de donn�es
	protected final static String NOM = "BudgetMonitorDBTemp.db";

	protected SQLiteDatabase mDb = null;
	protected Database mDatabase = null;

	public DAOBase(Context pContext) {
//		this.mDatabase = Database.getInstance(pContext, NOM, null, VERSION);
		this.mDatabase = new Database(pContext, NOM, null, VERSION);
	}

	public SQLiteDatabase open() {
		// Pas besoin de fermer la derni�re base puisque getWritableDatabase
		// s'en charge
		mDb = mDatabase.getWritableDatabase();
		return mDb;
	}

	public void close() {
		mDb.close();
	}

	public SQLiteDatabase getDb() {
		return mDb;
	}
}
