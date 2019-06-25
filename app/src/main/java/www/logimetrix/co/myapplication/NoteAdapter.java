package www.logimetrix.co.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder> {

    private List<Note> notes = new ArrayList<>();

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item, parent, false);
        return new NoteHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        holder.text_view_title.setText(notes.get(position).getTitle());
        holder.text_view_description.setText(notes.get(position).getDescription());
        holder.text_view_priority.setText(String.valueOf(notes.get(position).getPriority()));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
        notifyDataSetChanged();
    }

    public Note getNoteAt(int position) {
        return notes.get(position);
    }

    class NoteHolder extends RecyclerView.ViewHolder {

        private TextView text_view_priority, text_view_title, text_view_description;

        public NoteHolder(@NonNull View itemView) {
            super(itemView);
            text_view_title = itemView.findViewById(R.id.text_view_title);
            text_view_description = itemView.findViewById(R.id.text_view_description);
            text_view_priority = itemView.findViewById(R.id.text_view_priority);
        }
    }
}
