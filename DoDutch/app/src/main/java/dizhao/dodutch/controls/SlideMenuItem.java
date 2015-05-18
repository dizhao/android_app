package dizhao.dodutch.controls;

/**
 * Created by Di on 18/05/2015.
 */
public class SlideMenuItem {
    private int m_ItemID;
    private String m_Title;
    private String m_Description;
    private boolean m_IsHighLight;

    public void setItemID (int p_ItemID)
    {
        this.m_ItemID = p_ItemID;
    }

    public int getItemID (){
        return m_ItemID;
    }

    public void setTitle (String p_Title)
    {
        this.m_Title = p_Title;
    }

    public String getTitle (){
        return m_Title;
    }

    public void setDescription (String p_Description)
    {
        this.m_Description = p_Description;
    }

    public String getDescription (){
        return m_Description;
    }


    public SlideMenuItem(int p_ItemID, String p_Title)
    {
       setItemID(p_ItemID);
       setTitle(p_Title);
    }

    public SlideMenuItem(int p_ItemID, String p_Title, String p_Description)
    {
        setItemID(p_ItemID);
        setTitle(p_Title);
        setDescription(p_Description);
    }
}
