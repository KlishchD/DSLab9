package com.example.dslab9;

import com.example.dslab9.Core.Models.Album;
import com.example.dslab9.Core.Models.Artist;
import com.example.dslab9.Core.Repository.DBRepository;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.example.dslab9.Core.Repository.Repository;

@WebServlet(name = "ListAlbumsServlet", value = "/")
public class ListAlbumsServlet extends HttpServlet {
    Repository repository;

    @Override
    public void init() {
        repository = new DBRepository("jdbc:postgresql://localhost:5432/dev", "postgres", "postgres");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        List<Artist> artists = repository.getArtists();

        PrintWriter out = response.getWriter();
        out.println("<html><style>table, td, th { border: 1px solid #333; } thead, tfoot { background-color: #333; color: #fff; } </style>");
        out.println("<body><table>");
        out.println("<tr><th>Id</th><th>Name</th><th>Author Name</th></tr>");

        for (Artist artist: artists) {
            printArtist(out, artist);
        }

        out.println("</table></body></html>");
    }

    void printArtist(PrintWriter out, Artist artist) {
        for (Album album: artist.getAlbums()) {
            out.print("<tr>");
            out.print("<td>" + album.getId() + "</td>");
            out.print("<td>" + album.getName() + "</td>");
            out.print("<td>" + artist.getName() + "</td>");
            out.print("</tr>");
        }
    }

    public void destroy() {
    }
}