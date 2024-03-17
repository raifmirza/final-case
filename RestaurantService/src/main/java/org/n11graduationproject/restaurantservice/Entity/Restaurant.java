package org.n11graduationproject.restaurantservice.Entity;


import lombok.Getter;
import lombok.Setter;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

@Getter
@Setter
@SolrDocument(solrCoreName = "restaurants")
public class Restaurant {
    @Id
    @Indexed(name = "id",type = "string")
    private String id;
    @Indexed(name = "name",type = "string")
    private String name;
    @Indexed(name="type",type = "string")
    private String type;
    @Indexed(name = "score",type = "pdouble")
    private String score;
    @Indexed(name = "latitude",type = "pdouble")
    private String latitude;
    @Indexed(name="longitude",type = "pdouble")
    private String longitude;
    @Indexed(name="location",type = "location")
    private String location;
}
